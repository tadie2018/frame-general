package dev.td.corepersistencemgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zEidat
 * @since 2019-08-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_account")
public class SysAccount extends Model<SysAccount> {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 账户名/登录名
     */
    private String accountName;

    /**
     * 账户密码/登录密码
     */
    private String accountPassword;

    /**
     * 加密盐
     */
    private String encryptionSalt;

    /**
     * 账号状态：0/1
     */
    private Integer accountStatus;

    /**
     * 逻辑删除(可选) 0/1
     */
    private Integer logicalDelete;

    /**
     * 备注
     */
    private String note;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
