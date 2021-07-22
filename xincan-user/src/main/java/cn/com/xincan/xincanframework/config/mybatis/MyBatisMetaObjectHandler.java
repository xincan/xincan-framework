package cn.com.xincan.xincanframework.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-user
 * @description 元对象数据处理，Po自动填充create_time,edit_time
 * @author JiangXincan
 * @create 2021/7/20 17:45
 * @version 2.0.0
 */
@Component
@Slf4j
public class MyBatisMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createUserId", String.class , "1285759156342562818");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class , LocalDateTime.now());
        this.strictInsertFill(metaObject, "editUserId", String.class , "1285759156342562818");
        this.strictInsertFill(metaObject, "editTime", LocalDateTime.class , LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "editUserId", String.class , "1285759156342562818");
        this.strictUpdateFill(metaObject, "editTime", LocalDateTime.class , LocalDateTime.now());
    }

}
