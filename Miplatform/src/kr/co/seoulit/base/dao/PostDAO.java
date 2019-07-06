package kr.co.seoulit.base.dao;

import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.base.to.PostBean;

public interface PostDAO {

	List<PostBean> searchPostList(String dong) ;

	List<PostBean> searchSidoList();

	List<PostBean> searchSigunguList(String sido);

	List<PostBean> searchRoadList(HashMap<String, Object> map);
	
}
