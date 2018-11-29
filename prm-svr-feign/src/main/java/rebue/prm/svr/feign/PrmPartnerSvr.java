package rebue.prm.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.prm.mo.PrmPartnerMo;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "prm-svr", configuration = FeignConfig.class)
public interface PrmPartnerSvr {

	/**
	 * 获取单个伙伴信息
	 *
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@GetMapping("/prm/partner/getbyid")
	PrmPartnerMo getById(@RequestParam("id") java.lang.Long id);
	
	/**
	 * 获取单个伙伴信息(根据条件)
	 */
	@GetMapping("/prm/partner/getone")
	PrmPartnerMo getOne(PrmPartnerMo mo);
}
