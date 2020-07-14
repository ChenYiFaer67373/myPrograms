package pers.design.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.design.mapper.MusicListContentMapper;
import pers.design.mapper.MusicTopListMapper;

@Service
public class MusicSpiderImpl {
	@Resource
	private MusicTopListMapper musicTopListMapper;
	@Resource
	private MusicListContentMapper musicListContentMapper;
	
	public void ranSpider() {
		
	}
}
