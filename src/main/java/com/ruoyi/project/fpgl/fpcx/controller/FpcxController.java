package com.ruoyi.project.fpgl.fpcx.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.fpgl.fpcx.service.IFpmxService;
import com.ruoyi.project.fpgl.fpcx.service.IFpzbService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作日志记录
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/fpgl/fpcx")
public class FpcxController extends BaseController
{
    private String prefix = "fpgl/fpcx";

    @Autowired
    private IFpzbService fpzbService;

    @Autowired
    private IFpmxService fpmxService;

    @RequiresPermissions("fpgl:fpcx:view")
    @GetMapping()
    public String fpcx()
    {
        return prefix + "/fpcx";
    }

    @RequiresPermissions("fpgl:fpcx:view")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fpzb fpzb)
    {
        return fpzbService.selectFpcxList(fpzb);
    }

    @RequiresPermissions("fpgl:fpcx:detail")
    @GetMapping("/detail/{fpzbId}")
    public String detail(@PathVariable("fpzbId") String fpzbId, Model model)
    {
        Fpzb fpzb = fpzbService.selectFpzbById(fpzbId);
        List<Fpmx> fpmxs = fpmxService.selectFpmxDetailByZbid(fpzbId);
        model.addAttribute("fpzb", fpzb);
        model.addAttribute("fpmxs", fpmxs);
        String fplx = fpzb.getFplx();
        return prefix + "/cyjg" + fplx;
    }

}
