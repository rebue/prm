package rebue.prm.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 伙伴信息
 *
 * 数据库表: PRM_PARTNER
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class PrmPartnerMo implements Serializable {

    /**
     *    伙伴ID
     *
     *    数据库字段: PRM_PARTNER.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    伙伴名称
     *
     *    数据库字段: PRM_PARTNER.PARTNER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String partnerName;

    /**
     *    公司地址
     *
     *    数据库字段: PRM_PARTNER.COMPANY_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String companyAddress;

    /**
     *    联系方式
     *
     *    数据库字段: PRM_PARTNER.CONTACT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String contact;

    /**
     *    组织ID
     *
     *    数据库字段: PRM_PARTNER.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orgId;

    /**
     *    伙伴类型
     *
     *    数据库字段: PRM_PARTNER.PARTNER_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte partnerType;

    /**
     *    是否启用
     *
     *    数据库字段: PRM_PARTNER.IS_ENABLED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isEnabled;

    /**
     *    业务员ID
     *
     *    数据库字段: PRM_PARTNER.SALESMAN_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long salesmanId;

    /**
     *    备注
     *
     *    数据库字段: PRM_PARTNER.REMARK
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String remark;

    /**
     *    操作人ID
     *
     *    数据库字段: PRM_PARTNER.OP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long opId;

    /**
     *    创建时间
     *
     *    数据库字段: PRM_PARTNER.CREATE_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     *    修改时间
     *
     *    数据库字段: PRM_PARTNER.MODIFY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    伙伴ID
     *
     *    数据库字段: PRM_PARTNER.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    伙伴ID
     *
     *    数据库字段: PRM_PARTNER.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    伙伴名称
     *
     *    数据库字段: PRM_PARTNER.PARTNER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     *    伙伴名称
     *
     *    数据库字段: PRM_PARTNER.PARTNER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    /**
     *    公司地址
     *
     *    数据库字段: PRM_PARTNER.COMPANY_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     *    公司地址
     *
     *    数据库字段: PRM_PARTNER.COMPANY_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     *    联系方式
     *
     *    数据库字段: PRM_PARTNER.CONTACT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getContact() {
        return contact;
    }

    /**
     *    联系方式
     *
     *    数据库字段: PRM_PARTNER.CONTACT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     *    组织ID
     *
     *    数据库字段: PRM_PARTNER.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     *    组织ID
     *
     *    数据库字段: PRM_PARTNER.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     *    伙伴类型
     *
     *    数据库字段: PRM_PARTNER.PARTNER_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getPartnerType() {
        return partnerType;
    }

    /**
     *    伙伴类型
     *
     *    数据库字段: PRM_PARTNER.PARTNER_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPartnerType(Byte partnerType) {
        this.partnerType = partnerType;
    }

    /**
     *    是否启用
     *
     *    数据库字段: PRM_PARTNER.IS_ENABLED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     *    是否启用
     *
     *    数据库字段: PRM_PARTNER.IS_ENABLED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     *    业务员ID
     *
     *    数据库字段: PRM_PARTNER.SALESMAN_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getSalesmanId() {
        return salesmanId;
    }

    /**
     *    业务员ID
     *
     *    数据库字段: PRM_PARTNER.SALESMAN_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    /**
     *    备注
     *
     *    数据库字段: PRM_PARTNER.REMARK
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getRemark() {
        return remark;
    }

    /**
     *    备注
     *
     *    数据库字段: PRM_PARTNER.REMARK
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *    操作人ID
     *
     *    数据库字段: PRM_PARTNER.OP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOpId() {
        return opId;
    }

    /**
     *    操作人ID
     *
     *    数据库字段: PRM_PARTNER.OP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpId(Long opId) {
        this.opId = opId;
    }

    /**
     *    创建时间
     *
     *    数据库字段: PRM_PARTNER.CREATE_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *    创建时间
     *
     *    数据库字段: PRM_PARTNER.CREATE_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *    修改时间
     *
     *    数据库字段: PRM_PARTNER.MODIFY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     *    修改时间
     *
     *    数据库字段: PRM_PARTNER.MODIFY_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", partnerName=").append(partnerName);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", contact=").append(contact);
        sb.append(", orgId=").append(orgId);
        sb.append(", partnerType=").append(partnerType);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", salesmanId=").append(salesmanId);
        sb.append(", remark=").append(remark);
        sb.append(", opId=").append(opId);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PrmPartnerMo other = (PrmPartnerMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
