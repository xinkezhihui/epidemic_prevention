package com.xinke.epidemic_prevention.controller.notice;

import com.xinke.epidemic_prevention.bean.notice.IfRead;
import com.xinke.epidemic_prevention.bean.notice.Notice;
import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.service.notice.IfReadService;
import com.xinke.epidemic_prevention.service.notice.NoticeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * @Auther:Wening
 * @Date:2019/11/14
 * @Description:公告公示Controller
 * @version:1.0
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;
    @Autowired
    IfReadService ifReadService;

    /*管理员管理界面and用户浏览界面*/
    @RequestMapping("/show")
    public String show( @RequestParam Integer n_msg, Model model){    //list形式//"1"
        User user= (User) SecurityUtils.getSubject().getPrincipal();//此处应为获取登陆用户的id等值
        IfRead ifRead = ifReadService.queryById(user.getNumber());//查询当前user的未读消息表记录
        model.addAttribute("unreadNoticeLists",ifReadService.getNoticeByInfo(ifRead.getNoticeInfo(),1));//未读
        model.addAttribute("readNoticeLists",ifReadService.getNoticeByInfo(ifRead.getNoticeInfo(),0));//已读
        model.addAttribute("count",ifReadService.getCount(ifRead));//当前类型未读个数
        model.addAttribute("n_msg",n_msg);
        System.out.println(n_msg);
        return "notice/notice_crud";
    }
    /*删除功能*/
    @RequestMapping("/delete")
    public String delete(@RequestParam Integer notice_id, RedirectAttributes redirectAttributes){  //重定向传参//"2"
        ifReadService.setStringDelete(notice_id.toString());//删除(字符串形式！！)
        Boolean save = noticeService.deleteById(notice_id);
        if(save)redirectAttributes.addAttribute("n_msg",1);
        else redirectAttributes.addAttribute("n_msg",0);
        return "redirect:show"; //写notice/show的话，地址会变成/notice/notice/show
    }
    /*添加跳转*/
    @RequestMapping("toAdd")
    public String toAdd(Model model){ //"1"
        model.addAttribute("noticeListById",new Notice());
        return "notice/notice_operate";
    }
    /*修改跳转*/
    @RequestMapping("toEdit")
    public String toEdit(@RequestParam Integer notice_id, Model model){
        Notice notice = noticeService.queryById(notice_id);
        model.addAttribute("noticeListById",notice);
        return "notice/notice_operate";
    }
    /*管理员添加界面*//*(修改功能)*//*。@RequestParam用来处理Content-Type: 为 application/x-www-form-urlencoded编码的内容，提交方式GET、POST。*/
    @RequestMapping(value = "/operate" ,method = RequestMethod.POST)/*界面*/
    public String operate(Notice newNotice, RedirectAttributes redirectAttributes){  //重定向传参//notice形式//"2"
        Boolean save = noticeService.updateById(newNotice);
        System.out.println("修改/插入"+newNotice);
        if(save)redirectAttributes.addAttribute("n_msg",1);
        else redirectAttributes.addAttribute("n_msg",0);
        ifReadService.setStringAdd(newNotice.getId());//新增未读
        return "redirect:show";
    }
    /*浏览内容界面*/
    @RequestMapping("/browse")
    public String look(@RequestParam Integer notice_id, Model model){    //通过id查找，notice形式
        User user= (User) SecurityUtils.getSubject().getPrincipal();//此处应为获取登陆用户的id等值
        ifReadService.setStringDeleteOne(user.getNumber(),notice_id.toString());//删除(字符串形式！！)
        noticeService.updateClickById(notice_id);
        model.addAttribute("noticeListById",noticeService.queryById(notice_id));
        return "notice/notice_content";
    }
    @RequestMapping("/test")
    public String test(){
        return "notice/notice_crud";
    }
}
