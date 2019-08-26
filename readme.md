#                                通用框架 : 通用操作 服务拆分
### Author：zhangdong Time: 2019-8-25
## core-api-mgr : API统一管理
## core-persistence-mgr : 持久化管理 （数据库读写分离、多数据源）
* 读写分离
- 主写MYSQL 数据关系处理和业务依赖
- 主读ES 缓存数据库 类型默认TEXT，暂时不考虑搜索引擎和分词
* 但是所有的读写操作必须同时更新ES和MYSQL，否则缓存不同步
## core-authentication-mgr : 鉴权管理（包括登录、注册、权限、角色、菜单等）
## core-dev-tools : 开发工具包（代码生成器、其他工具等）
* 代码生成器使用说明：
- 默认使用的地址包含在`DBConstant`中
- 代码生成在`dev.td.coredevtools.cdag4cut`中，直接剪切出来即可
- 自定义配置直接修改`CodeGenerator`类即可
- `autoGenerator.setCfg` 不设置此处会抛出空指针异常
* note : 当前服务组件均支持服务注册高可用
