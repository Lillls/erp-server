package com.xjx.production.service.user;

import com.xjx.production.entity.user.UmsMember;
import com.xjx.production.repository.user.UmsMemberMapper;
import com.xjx.production.repository.user.UmsMemberRepository;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 *  UmsMember业务服务类
 * </p>
 *
 * @author xjx
 * @since 2024-05-10
 */
@Service
public class UmsMemberService {

    /**
     * umsMemberMapper
     */
    @Autowired
    UmsMemberMapper umsMemberMapper;

    /**
     * umsMemberRepository
     */
    @Autowired
    UmsMemberRepository umsMemberRepository;

    /**
     * 保存/更新对象
     * @param umsMember 待处理对象
     * @return Long 主键
     */
    public Long saveUmsMember(UmsMember umsMember){
        umsMemberRepository.saveOrUpdate(umsMember);
        return umsMember.getId();
    }

    /**
     * 保存/更新对象中的非空值
     * @param umsMember 待处理对象
     * @return Long 主键
     */
    public Long saveUmsMemberNotNull(UmsMember umsMember){
        umsMemberRepository.saveOrUpdatePatch(umsMember);
        return umsMember.getId();
    }

    /**
     * 根据主键查询对象
     * @param id 主键
     * @return UmsMember 对象实体
     */
    public UmsMember getUmsMemberById(Long id) {
        return umsMemberRepository.getById(id);
    }

    /**
     * 根据条件查询分页集合
     * @param umsMember 实体参宿对象
     * @return IPage<UmsMember> 分页对象
     */
    public IPage<UmsMember> pageByUmsMember(UmsMember umsMember) {
        return umsMemberRepository.pageByUmsMember(umsMember);
    }

    /**
     * 查询所有数据
     * @return List<UmsMember> 数据结果集合
     */
    public List<UmsMember> queryUmsMember() {
        return umsMemberRepository.list(null);
    }

    /**
     * 根据id删除对象
     * @param id 主键id
     * @return 是否删除成功 true：成功，false：失败
     */
    public Boolean deleteUmsMemberById(Long id) {
        return umsMemberRepository.removeById(id);
    }


}
