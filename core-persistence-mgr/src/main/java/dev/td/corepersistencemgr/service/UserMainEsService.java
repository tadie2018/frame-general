package dev.td.corepersistencemgr.service;

import dev.td.corepersistencemgr.entity.UserMain;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserMainEsService extends ElasticsearchRepository<UserMain,String> {

}
