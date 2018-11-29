package rebue.prm.ctrl;

import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rebue.prm.mo.PrmPartnerMo;
import rebue.prm.svc.PrmPartnerSvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.wheel.turing.JwtUtils;

/**
 * 伙伴信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class PrmPartnerCtrl {

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	private static final Logger _log = LoggerFactory.getLogger(PrmPartnerCtrl.class);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@Resource
	private PrmPartnerSvc svc;

	/**
	 * 删除伙伴信息
	 *
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@DeleteMapping("/prm/partner")
	Ro del(@RequestParam("id") java.lang.Long id) {
		_log.info("del PrmPartnerMo by id: {}", id);
		int result = svc.del(id);
		Ro ro = new Ro();
		if (result == 1) {
			String msg = "删除成功";
			_log.info("{}: id-{}", msg, id);
			ro.setMsg(msg);
			ro.setResult(ResultDic.SUCCESS);
			return ro;
		} else {
			String msg = "删除失败，找不到该记录";
			_log.error("{}: id-{}", msg, id);
			ro.setMsg(msg);
			ro.setResult(ResultDic.FAIL);
			return ro;
		}
	}

	/**
	 * 查询伙伴信息
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 *
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@GetMapping("/prm/partner")
	PageInfo<PrmPartnerMo> list(PrmPartnerMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum,
			@RequestParam(value = "pageSize", required = false) Integer pageSize, HttpServletRequest req) throws NumberFormatException, ParseException {
		if (pageNum == null)
			pageNum = 1;
		if (pageSize == null)
			pageSize = 5;
		_log.info("list PrmPartnerMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
		Map<String, Object> map = JwtUtils.getJwtAdditionInCookie(req);
		String orgId = String.valueOf(map.get("orgId"));
//		String orgId = String.valueOf("520874560590053376");
		mo.setOpOrgId(Long.parseLong(orgId));
		if (pageSize > 50) {
			String msg = "pageSize不能大于50";
			_log.error(msg);
			throw new IllegalArgumentException(msg);
		}
		PageInfo<PrmPartnerMo> result = svc.list(mo, pageNum, pageSize);
		_log.info("result: " + result);
		return result;
	}

	/**
	 * 获取单个伙伴信息
	 *
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@GetMapping("/prm/partner/getbyid")
	PrmPartnerMo getById(@RequestParam("id") java.lang.Long id) {
		_log.info("get PrmPartnerMo by id: " + id);
		return svc.getById(id);
	}
	
	/**
	 * 获取单个伙伴信息(根据条件)
	 */
	@GetMapping("/prm/partner/getone")
	PrmPartnerMo getOne(PrmPartnerMo mo) {
		_log.info("getone PrmPartnerMo mo: " + mo);
		return svc.getOne(mo);
	}

	/**
	 * 修改伙伴信息
	 */
	@PutMapping("/prm/partner")
	Ro modify(@RequestBody PrmPartnerMo mo, HttpServletRequest request) throws Exception {
		_log.info("modify PrmPartnerMo: {}", mo);
		Long loginId = JwtUtils.getJwtUserIdInCookie(request);
		mo.setOpId(loginId);
		mo.setModifyTime(new Date());
		try {
			return svc.modifyEx(mo);
		} catch (RuntimeException e) {
			Ro ro = new Ro();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String msg = "修改失败，出现运行时异常(" + sdf.format(new Date()) + ")";
			_log.error("{}: mo-{}", msg, mo);
			ro.setMsg(msg);
			ro.setResult(ResultDic.FAIL);
			return ro;
		}
	}

	/**
	 * 添加伙伴信息
	 *
	 * @param mo
	 * @param req 
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/prm/partner")
	Ro add(@RequestBody PrmPartnerMo mo, HttpServletRequest request, HttpServletRequest req) throws Exception {
		_log.info("add PrmPartnerMo: {}", mo);
		// 获取当前登录用户id
		Long loginId = JwtUtils.getJwtUserIdInCookie(request);
//		Long loginId = 520874560590053376L;
		mo.setOpId(loginId);
		Ro ro = new Ro();
		
		if (loginId == null) {
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("您没有登录，请登录后再试。。。");
			return ro;
		}
		
		Map<String, Object> map = JwtUtils.getJwtAdditionInCookie(req);
		String orgId = String.valueOf(map.get("orgId"));
//		String orgId = "520874560590053376";
		if (orgId == null || orgId.equals("") || orgId.equals("null")) {
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("您没有加入任何组织，请加入组织后再试。。。");
			return ro;
		}
		mo.setOpOrgId(Long.parseLong(orgId));
		try {
			return svc.addEx(mo);
		} catch (RuntimeException e) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String msg = "添加失败，出现运行时异常(" + sdf.format(new Date()) + ")";
			_log.error(msg + ": mo=" + mo, e);
			ro.setMsg(msg);
			ro.setResult(ResultDic.FAIL);
			return ro;
		}
	}

	/**
	 * 禁用或者启用伙伴
	 * 
	 * @param id
	 * @param isEnabled
	 * @param orgId
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws NumberFormatException
	 */
	@PutMapping("/prm/partner/enable")
	Ro enable(@RequestParam("id") Long id, @RequestParam("isEnabled") Boolean isEnabled,
			@RequestParam("orgId") Long orgId, HttpServletRequest request)
			throws NumberFormatException, ParseException {
		// 获取当前登录用户id
		Long loginId = JwtUtils.getJwtUserIdInCookie(request);
		PrmPartnerMo mo = new PrmPartnerMo();
		mo.setId(id);
		mo.setOrgId(orgId);
		mo.setIsEnabled(isEnabled);
		mo.setOpId(loginId);
		mo.setModifyTime(new Date());
		_log.info("禁用或者启用伙伴的参数为：{}", mo);
		try {
			return svc.enable(mo);
		} catch (RuntimeException e) {
			Ro ro = new Ro();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String msg = "添加失败，出现运行时异常(" + sdf.format(new Date()) + ")";
			_log.error(msg + ": mo=" + mo, e);
			ro.setMsg(msg);
			ro.setResult(ResultDic.FAIL);
			return ro;
		}
	}
}
