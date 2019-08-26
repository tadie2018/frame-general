package dev.td.corepersistencemgr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@TableName("user_main")
@Document(indexName = "user_main")
public class UserMain extends Model<UserMain> {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 用户名
     */
    @Field(type= FieldType.Text)
    private String userName;

    /**
     * 性别 0 女 1 男
     */
    @Field(type= FieldType.Text)
    private Integer userSex;

    /**
     * 手机号
     */
    @Field(type= FieldType.Text)
    private String userMobile;

    /**
     * 备注
     */
    @Field(type= FieldType.Text)
    private String note;

    /**
     * 创建时间
     */
    @Field(type= FieldType.Text)
    @TableField("createTime")
    private Date createTime;

    /**
     * 记录更新时间
     */
    @Field(type= FieldType.Text)
    @TableField("updateTime")
    private Date updateTime;

    /**
     * 逻辑删除 0/ 1
     */
    @Field(type= FieldType.Text)
    private Integer logicalDelete;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
