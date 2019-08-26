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
@TableName("account_user")
public class AccountUser extends Model<AccountUser> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String accountId;

    @TableField("createTime")
    private Date createTime;

    @TableField("updateTime")
    private Date updateTime;

    /**
     * 逻辑删除 0 1
     */
    private Integer logicalDelete;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
