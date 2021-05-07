package com.graduate.loyee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.graduate.loyee.mapper")
public class ServiceUser8082 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUser8082.class,args);
    }

    /*
    RE
        List<Epidemic> getEpidemicData(Epidemic parm);

  <select id="getEpidemicData" parameterType="com.graduate.loyee.entity.Epidemic" resultType="com.graduate.loyee.entity.Epidemic">
    SELECT
    <include refid="Base_Column_List" />
    FROM epidemic
    WHERE
    <if test="status != null">
      `status` = #{status,jdbcType=INTEGER}
    </if>
    <if test="type != null">
      AND `type` = #{type,jdbcType=INTEGER}
    </if>
    <if test="time != null">
      AND `time` = #{time,jdbcType=TIMESTAMP}
    </if>
    ORDER BY time desc
    LIMIT 5
  </select>
    * */
}
