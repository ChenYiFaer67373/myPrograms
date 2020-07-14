package pers.design.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.NewGameMapper;
import pers.design.pojo.NewGame;
import pers.design.service.NewGameService;

@Service
public class NewGameServiceImpl implements NewGameService {
	@Resource
	private NewGameMapper newGameMapper;
	
	@Override
	public List<NewGame> selAll() {
		return newGameMapper.selAll();
	}

	@Override
	public List<NewGame> selByDate() {
		return newGameMapper.selByDate();
	}

	@Override
	public List<NewGame> selByScore() {
		return newGameMapper.selByScore();
	}

	@Override
	public int updateData(List<NewGame> list) {
		try {
			for (NewGame newGame : list) {
				newGameMapper.insertData(newGame);
			}
			System.out.println("数据更新完成！");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void delAllData() {
		newGameMapper.delAllData();

	}

}
