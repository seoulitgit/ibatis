 package kr.co.seoulit.base.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.base.to.PostBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PostDAOImpl extends SqlMapClientDaoSupport implements PostDAO{
	
	@SuppressWarnings("unchecked")
	public List<PostBean> searchPostList(String dong)  {
		System.out.println(dong);
		return getSqlMapClientTemplate().queryForList("Post.searchPostList", dong);
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<PostBean> searchSidoList()  {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Post.searchSidoList");

	}
	@Override
	public List<PostBean> searchSigunguList(String sido) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("Post.searchSigunguList",sido);

	}
	
	@Override
	public List<PostBean> searchRoadList(HashMap<String, Object> map) {
	return getSqlMapClientTemplate().queryForList("Post.searchRoadList",map);

	}

}
