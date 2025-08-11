---0511取近一天内S1001投放申请量A0v5-A占比/A+B占比；
select sx_time
     ,sum(A_A0V5_cnt) * 1.0000 / sum(all_cnt) AS "A占比"
     ,(sum(A_A0V5_cnt) + sum(B_A0V5_cnt)) * 1.0000 / sum(all_cnt) AS "A+B占比"
from
    (
        select
            a.sx_time
             ,count(distinct case when  mdl_loan_risk_new_a0_score_v5_0>625 and mdl_loan_risk_new_a0_score_v5_0<=900 then a.user_guid else null end) A_A0V5_cnt
             ,count(distinct case when  mdl_loan_risk_new_a0_score_v5_0>529 and mdl_loan_risk_new_a0_score_v5_0<=625 then  a.user_guid else null end) B_A0V5_cnt
             ,count(distinct  a.user_guid) all_cnt
        from
            (
                select
                    substr(impress_start_time,1,10) as sx_time
                     ,user_guid
                     ,max(case when impress_name='mdl_loan_risk_new_a0_score_v5_0' then cast(impress_value as double) else null end ) as mdl_loan_risk_new_a0_score_v5_0--A0_V5
                --,max(case when impress_name='ls_toufang_rule_score' then cast(impress_value as double) else null end ) as ls_toufang_rule_score--规则分
                from fintech.fintech_fpt_dwd_rsk_fpt_impress_compact_di
                where pt='20250510'
                  and event_codes='S1001'
                  and impress_name in ('mdl_loan_risk_new_a0_score_v5_0')--A0_V5&规则分
                  and strategy_set_ids in ('7312487623251400709')--投放策略集
                group by 1,2
            )a
        where mdl_loan_risk_new_a0_score_v5_0>=0--限制A0_V5不为null
        group by 1
    )tt1
group by 1
----
---0511近一天内S1001投放申请量规则分-A占比/A+B占比；
select sx_time
     ,sum(A_rule_cnt) * 1.0000 / sum(all_cnt) AS "A占比"
     ,(sum(B_rule_cnt) + sum(A_rule_cnt)) * 1.0000 / sum(all_cnt) AS "A+B占比"
from
    (
        select
            a.sx_time
             ,count(distinct case when  ls_toufang_rule_score=1 then a.user_guid else null end) A_rule_cnt
             ,count(distinct case when  ls_toufang_rule_score=2 then  a.user_guid else null end) B_rule_cnt
             ,count(distinct  a.user_guid) all_cnt
        from
            (
                select
                    substr(impress_start_time,1,10) as sx_time
                     ,user_guid
                     -- ,max(case when impress_name='mdl_loan_risk_new_a0_score_v5_0' then cast(impress_value as double) else null end ) as mdl_loan_risk_new_a0_score_v5_0--A0_V5
                     ,max(case when impress_name='ls_toufang_rule_score' then cast(impress_value as double) else null end ) as ls_toufang_rule_score--规则分
                from fintech.fintech_fpt_dwd_rsk_fpt_impress_compact_di
                where pt='20250510'
                  and event_codes='S1001'
                  and impress_name in ('ls_toufang_rule_score')--A0_V5&规则分
                  and strategy_set_ids in ('7312487623251400709')--投放策略集
                group by 1,2
            )a
        where ls_toufang_rule_score>=0--限制规则分不为null
        group by 1
    )tt1
group by 1



SELECT
    CASE
        WHEN SUM(mdl_loan_risk_new_a0_score_v5_0_a_count) = 0 THEN 0
        ELSE ROUND(SUM(mdl_loan_risk_new_a0_score_v5_0_a_count) / SUM(mdl_loan_risk_new_a0_score_v5_0_count), 4)
        END AS ratio
FROM
    dwd_yukon_fpt_appkeplerdata_S1001_dvertising_agg
WHERE
    event_day <= DATE_SUB(DATE(NOW()), INTERVAL 1 DAY) AND event_day >= DATE_SUB(DATE(NOW()), INTERVAL 3 DAY)
    limit 1;



select CASE
           WHEN sum(mdl_loan_risk_new_a0_score_v5_0_a_count) = 0 THEN 0
           ELSE ROUND(sum(mdl_loan_risk_new_a0_score_v5_0_a_count) / sum(mdl_loan_risk_new_a0_score_v5_0_count),4)
           END AS ratio from (
                                 SELECT
                                     STR_TO_DATE(
                                             CONCAT(
                                                     DATE_FORMAT(event_day, '%Y-%m-%d'),
                                                     ' ',
                                                     LPAD(event_hour, 2, '0'),
                                                     ':00:00'
                                             ),
                                             '%Y-%m-%d %H:%i:%s'
                                     ) as time,
  mdl_loan_risk_new_a0_score_v5_0_a_count,
  mdl_loan_risk_new_a0_score_v5_0_b_count,
  mdl_loan_risk_new_a0_score_v5_0_count
                                 FROM
                                     dwd_yukon_fpt_appkeplerdata_S1001_dvertising_agg
                                 WHERE
                                     event_day >= DATE_SUB(DATE(NOW()), INTERVAL 1 DAY)
                             ) t where  time >= (NOW() - INTERVAL 7 HOUR ) and  time <= (NOW() - INTERVAL 1 HOUR)
    limit 1




select CASE
           WHEN sum(ls_toufang_rule_score_a_count) = 0 THEN 0
           ELSE ROUND(sum(ls_toufang_rule_score_a_count) + sum(ls_toufang_rule_score_b_count) / sum(ls_toufang_rule_score_b_count_count),4)
           END AS ratio from (
                                 SELECT
                                     STR_TO_DATE(
                                             CONCAT(
                                                     DATE_FORMAT(event_day, '%Y-%m-%d'),
                                                     ' ',
                                                     LPAD(event_hour, 2, '0'),
                                                     ':00:00'
                                             ),
                                             '%Y-%m-%d %H:%i:%s'
                                     ) as time,
  ls_toufang_rule_score_a_count,
  ls_toufang_rule_score_b_count,
  ls_toufang_rule_score_b_count_count
                                 FROM
                                     dwd_yukon_fpt_appkeplerdata_S1001_dvertising_agg
                                 WHERE
                                     event_day >= DATE_SUB(DATE(NOW()), INTERVAL 1 DAY)
                             ) t where  time >= (NOW() - INTERVAL 13 HOUR ) and  time <= (NOW() - INTERVAL 1 HOUR)
    limit 1