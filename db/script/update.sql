-- 2018-11-12
alter table PRM_PARTNER add unique key AK_OP_ORG_AND_PARTNER_NAME(PARTNER_NAME, OP_ORG_ID);
alter table PRM_PARTNER modify ORG_ID               bigint null comment '组织ID
            当前伙伴如果是线上的，进行统一管理其组织，设置对应的组织ID，
            如果是线下的伙伴，不用设置，可为null';




-- ---------------------------------------- 下面的已经更新到线上 ----------------------------------------


-- 2018-11-9
alter table PRM_PARTNER add OP_ORG_ID            bigint not null comment '操作组织';