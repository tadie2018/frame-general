package dev.td.corepersistencemgr.service.impl;

import dev.td.corepersistencemgr.entity.AccountUser;
import dev.td.corepersistencemgr.mapper.AccountUserMapper;
import dev.td.corepersistencemgr.service.AccountUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zEidat
 * @since 2019-08-25
 */
@Service
public class AccountUserServiceImpl extends ServiceImpl<AccountUserMapper, AccountUser> implements AccountUserService {

}
