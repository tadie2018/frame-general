package dev.td.corepersistencemgr.controller;

import cn.hutool.json.JSONUtil;
import dev.td.coredevtools.ptutils.PersistenceUtil;
import dev.td.corepersistencemgr.entity.UserMain;
import dev.td.corepersistencemgr.service.UserMainEsService;
import dev.td.corepersistencemgr.service.UserMainService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProviderController {
    @Autowired
    private UserMainService userMainService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private UserMainEsService userMainEsService;
    @GetMapping("/query")
    public String query(@RequestParam("id") String id){
//        boolean index = elasticsearchTemplate.createIndex(UserMain.class);
//        UserMain userMain = new UserMain();
//        userMain.setId(PersistenceUtil.uuid());
//        userMain.setUserSex(1);
//        userMain.setUserName("张栋");
//        userMain.setCreateTime(new Date());
//        userMain.setUpdateTime(new Date());
//        userMain.setNote("测试读写分离");
//        userMain.setLogicalDelete(0);
//        UserMain save = userMainEsService.save(userMain);
//        boolean save1 = userMainService.save(userMain);
        Map<String,Object> map = new HashMap<>();
//        map.put("ES_index：创建索引",index);
//        map.put("ES_save：保存数据",save);
//        map.put("MySQL_save：保存数据",save1);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("userName","张栋");
//        boolQueryBuilder.must(termQueryBuilder);
        long mysqlBegin = System.currentTimeMillis();
        List<UserMain> list = userMainService.list();
        long mysqlEnd = System.currentTimeMillis();
        map.put("mysql-list:",list);
        map.put("MYSQL查询时间：1条记录",mysqlEnd - mysqlBegin);
        long esBegin = System.currentTimeMillis();
        Iterable<UserMain> search = userMainEsService.search(boolQueryBuilder);
        long esEnd = System.currentTimeMillis();
        map.put("es-search:",search);
        map.put("ES查询时间：2条记录",esEnd - esBegin);
        return JSONUtil.toJsonStr(map);
    }
}
