package com.ruoyi.framework.web.controller;

import java.util.List;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.web.page.PageDomain;
import com.ruoyi.framework.web.page.PageUtilEntity;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.support.TableSupport;
import com.ruoyi.project.system.user.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


/**
 * web层通用数据处理
 * 
 * @author ruoyi
 */
public class BaseController
{
    /**
     * 获取请求分页数据
     */
    public PageUtilEntity getPageUtilEntity()
    {
        PageUtilEntity pageUtilEntity = TableSupport.buildPageRequest();
        return pageUtilEntity;
    }




    /**
     * 获取分页请求
     * @return
     */
    protected PageRequest getPageRequest(PageDomain pageDomain){
        int page = 1;
        int size = 10;
        Sort sort = null;
        page=  pageDomain.getPageNum();
        size = pageDomain.getPageSize();
        try {
            String sortName = pageDomain.getOrderByColumn();
            String sortOrder = pageDomain.getIsAsc();
            if(StringUtils.isNoneBlank(sortName) && StringUtils.isNoneBlank(sortOrder)){
                if(sortOrder.equalsIgnoreCase("desc")){
                    sort = new Sort(Sort.Direction.DESC, sortName);
                }else{
                    sort = new Sort(Sort.Direction.ASC, sortName);
                }
            }
            page = page - 1;
            size = size;
        } catch (Exception e) {
            e.printStackTrace();
        }
        PageRequest pageRequest = new PageRequest(page, size, sort);
        return pageRequest;
    }



    public User getUser()
    {
        return ShiroUtils.getUser();
    }

    public Long getUserId()
    {
        return getUser().getUserId();
    }

    public String getLoginName()
    {
        return getUser().getLoginName();
    }
}
