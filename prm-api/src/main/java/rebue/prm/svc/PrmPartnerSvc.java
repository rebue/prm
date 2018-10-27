package rebue.prm.svc;

import rebue.prm.mo.PrmPartnerMo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 伙伴信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface PrmPartnerSvc extends MybatisBaseSvc<PrmPartnerMo, java.lang.Long> {

	/**
	 * 添加伙伴
	 * @param mo
	 * @return
	 */
	Ro addEx(PrmPartnerMo mo);

	/**
	 * 禁用或者启用伙伴
	 * @param mo
	 * @return
	 */
	Ro enable(PrmPartnerMo mo);

	/**
	 * 修改伙伴信息
	 * @param mo
	 * @return
	 */
	Ro modifyEx(PrmPartnerMo mo);
}
