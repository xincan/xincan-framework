package cn.com.xincan.xincanframework.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * copyright (C), 2021, 北京同创永益科技发展有限公司
 * @program xincan-framework
 * @description 元对象数据处理，Po自动填充create_time,edit_time
 * @author JiangXincan
 * @create 2021/7/20 17:45
 * @version 2.0.0
 */
@Component
@Slf4j
public class MyBatisMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_USER_ID = "createUserId";
    private static final String CREATE_TIME = "createTime";
    private static final String EDIT_USER_ID = "editUserId";
    private static final String EDIT_TIME = "editTime";


    private void setIdAndTime(MetaObject metaObject, String id, String time) {
        boolean hasId = metaObject.hasSetter(id);
        if(hasId) {
            this.strictInsertFill(metaObject, id, String.class , "1285759156342562818");
        }
        boolean hasTime = metaObject.hasSetter(time);
        if(hasTime) {
            this.strictInsertFill(metaObject, time, LocalDateTime.class , LocalDateTime.now());
        }
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        setIdAndTime(metaObject, CREATE_USER_ID, CREATE_TIME);
        setIdAndTime(metaObject, EDIT_USER_ID, EDIT_TIME);
    }



    @Override
    public void updateFill(MetaObject metaObject) {
        boolean hasEditUserId = metaObject.hasSetter(EDIT_USER_ID);
        if(hasEditUserId) {
            this.strictUpdateFill(metaObject, EDIT_USER_ID, String.class , "1285759156342562818");
        }
        boolean hasEditTime = metaObject.hasSetter(EDIT_TIME);
        if(hasEditTime) {
            this.strictUpdateFill(metaObject, EDIT_TIME, LocalDateTime.class, LocalDateTime.now());
        }

    }

}
