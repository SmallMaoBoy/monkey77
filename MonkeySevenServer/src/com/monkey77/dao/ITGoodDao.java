/**
 * @date:创建时间：2015-12-23上午11:17:58
 * @author:mao
 * 
 */
package com.monkey77.dao;

import java.util.List;

import com.monkey77.entities.TGood;

/**
 * @author mao
 * @time 创建时间 2015-12-23上午11:17:58
 * 
 */
public interface ITGoodDao {

	// 保存商品
	public int saveGood(TGood good);

	// 按照销量从小到大获取指定区间的商品列表
	public List<TGood> getGoodsBySaleVolumeAsc(int firstIndex, int num);

	// 按照销量从大到小获取指定区间的商品列表
	public List<TGood> getGoodsBySaleVolumeDesc(int firstIndex, int num);

	// 获取总共商品数量
	public int getTotalCount();

	// 获取按价格从高到低指定区间的商品
	public List<TGood> getGoodsByPriceAsc(int firstIndex, int num);

	// 获取按照价格从低到高指定区间的商品
	public List<TGood> getGoodsByPriceDesc(int firstIndex, int num);

	// 获取按照某分类的商品，按照价格从大到小
	public List<TGood> getGoodsByPriceWithSortDesc(int firstIndex, int num,
			String sort);

	// 获取按照某分类的商品，按照价格从小到大
	public List<TGood> getGoodsByPriceWithSortAsc(int firstIndex, int num,
			String sort);

	// 获取按照某分类的商品，按照销量从小到大
	public List<TGood> getGoodsBySaleVolumeWithSortAsc(int firstIndex, int num,
			String sort);

	// 获取按照某分类的商品，按照销量从大到小
	public List<TGood> getGoodsBySaleVolumeWithSortDesc(int firstIndex,
			int num, String sort);

	// 获取指定种类商品的数量
	public int getCountWithSort(String sort);

	// 获取关键字相关商品的数量
	public int getCountWithKeyWords(String keyWords);

	// 获取按照关键字的商品，按照价格从大到小
	public List<TGood> getGoodsByPriceWithKeyWordsDesc(int firstIndex, int num,
			String keyWords);

	// 获取按照关键字的商品，按照价格从小到大
	public List<TGood> getGoodsByPriceWithKeyWordsAsc(int firstIndex, int num,
			String keyWords);

	// 获取按照关键字的商品，按照销量从小到大
	public List<TGood> getGoodsBySaleVolumeWithKeyWordsAsc(int firstIndex,
			int num, String keyWords);

	// 获取按照关键字的商品，按照销量从大到小
	public List<TGood> getGoodsBySaleVolumeWithKeyWordsDesc(int firstIndex,
			int num, String keyWords);
	
	//根据商品id获取商品
	public TGood getGoodById(int id);
	
	
	//根据商品id获取商品名字
	public String getGoodNameById(int id);
	
	//更改商品数量(减少)
	public void decreaseGoodNum(int id,int num);
	
	//更新商品
	public void updateGood(TGood good);
}
