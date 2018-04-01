package com.xiangqin.service;

import java.util.List;

import com.xiangqin.domain.Letter;

public interface LetterService {

	Integer save(Letter letter);

	List<Letter> list(Integer fromId);
}
