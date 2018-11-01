package rebue.prm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import rebue.prm.mo.PrmPartnerMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PrmPartnerMapper extends MybatisBaseMapper<PrmPartnerMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PrmPartnerMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PrmPartnerMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PrmPartnerMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PrmPartnerMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PrmPartnerMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PrmPartnerMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PrmPartnerMo> selectSelective(PrmPartnerMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PrmPartnerMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PrmPartnerMo record);
    
    /**
     * 根据伙伴名称判断该伙伴是否已存在
     * @param partnerName
     * @return
     */
    @Select("select count(*) from PRM_PARTNER where PARTNER_NAME = '${partnerName}'")
    boolean existByPartnerName(@Param("partnerName") String partnerName);
}
