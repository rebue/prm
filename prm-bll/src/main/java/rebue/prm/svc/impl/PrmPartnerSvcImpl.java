package rebue.prm.svc.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.prm.mapper.PrmPartnerMapper;
import rebue.prm.mo.PrmPartnerMo;
import rebue.prm.svc.PrmPartnerSvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

/**
 * 伙伴信息
 *
 * 在单独使用不带任何参数的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class PrmPartnerSvcImpl extends MybatisBaseSvcImpl<PrmPartnerMo, java.lang.Long, PrmPartnerMapper> implements PrmPartnerSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PrmPartnerSvcImpl.class);
    
    @Resource
    private PrmPartnerSvc thisSvc;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(PrmPartnerMo mo) {
        _log.info("添加伙伴信息");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }
    
    public Ro addEx(PrmPartnerMo mo) {
    	_log.info("添加伙伴信息的参数为：{}", mo);
    	Ro ro = new Ro();
    	if (StringUtils.isAnyBlank(mo.getPartnerName(), mo.getContact()) || mo.getPartnerType() == null) {
    		_log.error("添加伙伴信息出现参数错误");
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("参数错误");
			return ro;
		}
    	Long orgId = _idWorker.getId();
    	mo.setId(_idWorker.getId());
    	mo.setOrgId(orgId);
    	mo.setIsEnabled(true);
    	mo.setCreateTime(new Date());
    	_log.info("添加伙伴信息的参数为：{}", mo);
    	int addResult = thisSvc.add(mo);
    	_log.info("添加伙伴信息的返回值为：{}", addResult);
    	if (addResult != 1) {
			
		}
    	return ro;
    }
}
