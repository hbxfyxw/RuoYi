package com.ruoyi.project.fpgl.fpcx.domain;

import com.ruoyi.framework.web.page.PageDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 操作日志记录 oper_log
 * 
 * @author ruoyi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Fpzb extends PageDomain
{
    //发票通用信息
    private String id;
    private String fpdm;
    private String fphm;
    private String kprq;
    private String gfsh;
    private String xfsh;
    private Double je;
    private Double se;
    private Double jshj;
    private String fplx;
    private String gfmc;
    private String xfmc;
    private String zfbz;
    private String lrrymc;
    private String lrrydm;
    private String bz;
    private String gfdzdh;
    private String gfyhzh;
    private String xfdzdh;
    private String xfyhzh;
    private String jym;
    private String jqbm;
    private String jecn;//金额大写
    private String slv;
    private String userid;//微信用户名
    private String ewm;//二维码
    private String czsj;//操作时间
    private String status;//发票状态
    private String shy;//收货员 卷票
    private String cycs;//查验次数
    private Long imgCount;//图片张数

    //货运发票  没明细
    private String cyr; //承运人
    private String cyrsh;//承运人纳税识别号
    private String spf;//实际受票方
    private String spfsh;//实际受票方纳税人识别号
    private String shr;//收货人
    private String shrsh;//收货人纳税识别号
    private String fhr;//发货人
    private String fhrsh;//发货人纳税识别号
    private String yshwxx;//运输货物信息
    private String qyd;//起运地
    private String czch;//车种车号
    private String dw;//车船吨位

    //机动车发票
    private String cllx;//车辆类型
    private String cpxh;//车牌型号
    private String cd;//产地
    private String hgzh;//合格证号
    private String jkzmsh;//进口证明书号
    private String sjdh;//商检单号
    private String fdjhm;//发动机号码
    private String clsbdh;//车辆识别代号
    private String dz;//地址
    private String dh;//电话
    private String khyh;//开户银行
    private String zh;//账号
    private String xcrs;//限乘人数
    private String wspzhm;//完税凭证号码
    private String zgswjg;//主管税务机关名称;
    private String zgswjgdm;//主管税务机关代码
    private String sfz;//身份证;

    //通行费
    private String txfse;  //通信费税额  有可能为 *** 特殊字符 单独处理
}
