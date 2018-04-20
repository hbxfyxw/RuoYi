package com.ruoyi.project.fpgl.fpcx.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.JSON;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.fpgl.fpcx.service.IFpcxService;
import com.ruoyi.project.monitor.operlog.domain.OperLog;
import com.ruoyi.project.monitor.operlog.service.IOperLogService;
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
    private IFpcxService fpcxService;

    @RequiresPermissions("fpgl:fpcx:view")
    @GetMapping()
    public String fpcx()
    {
        return prefix + "/fpcx";
    }

    @RequiresPermissions("fpgl:fpcx:list")
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fpzb fpzb)
    {
        setPageInfo(fpzb);
        List<Fpzb> list = fpcxService.selectFpcxList(fpzb);
        return getDataTable(list);
    }

    @RequiresPermissions("fpgl:fpcx:detail")
    @GetMapping("/detail/{fpzbId}")
    public String detail(@PathVariable("fpzbId") String fpzbId, Model model)
    {
        Fpzb fpzb = fpcxService.selectFpcxById(fpzbId);
        List<Fpmx> fpmxs = fpcxService.selectFpcxDetailList(fpzbId);
        model.addAttribute("fpzb", fpzb);
        model.addAttribute("fpmxs", fpmxs);
        String fplx = fpzb.getFplx();
        return prefix + "/cyjg" + fplx;
    }

}
