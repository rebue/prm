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
import rebue.suc.mo.SucOrgMo;
import rebue.suc.ro.SucOrgRo;
import rebue.suc.svr.feign.SucOrgSvc;

/**
 * 伙伴信息
 *
 * 在单独使用不带任何参数的 @Transactional 注释时， propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED， 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意： 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class PrmPartnerSvcImpl extends MybatisBaseSvcImpl<PrmPartnerMo, java.lang.Long, PrmPartnerMapper>
		implements PrmPartnerSvc {

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	private static final Logger _log = LoggerFactory.getLogger(PrmPartnerSvcImpl.class);

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

	@Resource
	private PrmPartnerSvc thisSvc;

	@Resource
	private SucOrgSvc sucOrgSvc;

	/**
	 * 添加伙伴
	 * 
	 * @param mo
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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
		mo.setIsEnabled(false);
		mo.setCreateTime(new Date());
		mo.setModifyTime(new Date());
		_log.info("添加伙伴信息的参数为：{}", mo);
		int addResult = thisSvc.add(mo);
		_log.info("添加伙伴信息的返回值为：{}", addResult);
		if (addResult != 1) {
			_log.error("添加伙伴信息出错，操作人id为：{}", mo.getOpId());
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("添加出错");
			return ro;
		}
		// 添加组织信息
		SucOrgMo orgMo = new SucOrgMo();
		orgMo.setId(orgId);
		orgMo.setName(mo.getPartnerName());
		orgMo.setIsEnabled(false);
		orgMo.setRemark(mo.getRemark());
		orgMo.setCreateTimestamp(System.currentTimeMillis());
		_log.info("添加伙伴添加组织信息的参数为：{}", orgMo);
		SucOrgRo orgRo = sucOrgSvc.add(orgMo);
		_log.info("添加伙伴添加组织信息的返回值为：{}", orgRo);
		if (orgRo.getResult() != 1) {
			_log.info("添加伙伴添加组织信息出错，操作人id为：{}", mo.getOpId());
			throw new RuntimeException("操作出错");
		}
		_log.info("添加伙伴成功，操作人id为：{}", mo.getOpId());
		ro.setResult(ResultDic.SUCCESS);
		ro.setMsg("操作成功");
		return ro;
	}

	/**
	 * 禁用或者启用伙伴
	 * 
	 * @param mo
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Ro enable(PrmPartnerMo mo) {
		_log.info("禁用或者启用伙伴的参数为：{}", mo);
		Ro ro = new Ro();
		if (mo.getOpId() == null) {
			_log.error("禁用或者启用伙伴时发现操作人未登录");
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("您未登录");
			return ro;
		}
		if (mo.getId() == null || mo.getIsEnabled() == null) {
			_log.error("禁用或者启用伙伴出现参数不全，操作人为：{}", mo.getOpId());
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("参数不正确");
			return ro;
		}
		_log.info("禁用或者启用伙伴的参数为：{}", mo);
		int modifyResult = thisSvc.modify(mo);
		_log.info("禁用或者启用伙伴的返回值为：{}", modifyResult);
		if (modifyResult != 1) {
			_log.error("禁用或者启用伙伴时出现错误，操作人id为：{}", mo.getOpId());
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("操作失败");
		}
		_log.info("禁用或者启用伙伴禁用或者启用组织的参数为：id: {}===isEnabled: {}", mo.getOrgId(), mo.getIsEnabled());
		SucOrgRo orgRo = sucOrgSvc.enable(mo.getOrgId(), mo.getIsEnabled());
		_log.info("禁用或者启用伙伴禁用或者启用组织的返回值为：{}", orgRo);
		if (orgRo.getResult() != 1) {
			_log.error("禁用或者启用伙伴禁用或者启用组织出现错误，操作人id为：{}", mo.getOpId());
			throw new RuntimeException("设置出错");
		}
		_log.info("禁用或者启用伙伴成功，操作人id为：{}", mo.getOpId());
		ro.setResult(ResultDic.SUCCESS);
		ro.setMsg("操作成功");
		return ro;
	}

	/**
	 * 修改伙伴信息
	 * @param mo
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Ro modifyEx(PrmPartnerMo mo) {
		_log.info("修改伙伴信息的参数为：{}", mo);
		Ro ro = new Ro();
		if (mo.getOpId() == null) {
			_log.error("修改伙伴信息时出现用户未登录");
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("您未登录，请登录后再试。。。");
			return ro;
		}

		if (StringUtils.isAnyBlank(mo.getPartnerName(), mo.getContact()) || mo.getPartnerType() == null
				|| mo.getId() == null) {
			_log.error("修改伙伴信息出现参数错误");
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("参数错误");
			return ro;
		}
		_log.info("修改伙伴信息的参数为：{}", mo);
		int modifyResult = thisSvc.modify(mo);
		_log.info("修改伙伴信息的返回值为：{}", modifyResult);
		if (modifyResult != 1) {
			_log.error("修改伙伴信息出现错误，操作人id为：{}", mo.getOpId());
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("操作错误");
			return ro;
		}
		
		SucOrgMo orgMo = new SucOrgMo();
		orgMo.setId(mo.getOrgId());
		orgMo.setName(mo.getPartnerName());
		orgMo.setRemark(mo.getRemark());
		orgMo.setCreateTimestamp(System.currentTimeMillis());
		_log.info("修改伙伴信息修改组织信息的参数为：{}", orgMo);
		SucOrgRo sucOrgRo = sucOrgSvc.modify(orgMo);
		_log.info("修改伙伴信息修改组织信息的返回值为：{}", sucOrgRo);
		if (sucOrgRo.getResult() != 1) {
			_log.error("修改伙伴信息修改组织信息出现错误，操作人id为：{}", mo.getOpId());
			throw new RuntimeException("修改出错");
		}
		_log.info("修改伙伴信息成功，操作人id为：{}", mo.getOpId());
		ro.setResult(ResultDic.SUCCESS);
		ro.setMsg("操作成功");
		return ro;
	}
}
