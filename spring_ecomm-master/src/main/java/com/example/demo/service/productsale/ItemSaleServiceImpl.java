package com.example.demo.service.productsale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.entity.ItemSale;
import com.example.demo.respositories.ItemResponsitory;
import com.example.demo.respositories.ItemSaleResponsitory;
@Service
public class ItemSaleServiceImpl implements ItemSaleService{
	
	@Autowired
	ItemSaleResponsitory itemSaleResponsitory;

	@Override
	public ItemSale save(ItemSale entity) {
		return itemSaleResponsitory.save(entity);
	}

	@Override
	public List<ItemSale> saveAll(List<ItemSale> entities) {
		return (List<ItemSale>)itemSaleResponsitory.saveAll(entities);
	}

	@Override
	public Optional<ItemSale> findById(Integer id) {
		return itemSaleResponsitory.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return itemSaleResponsitory.existsById(id);
	}

	@Override
	public  List<ItemSale> findAll() {
		return (List<ItemSale>)itemSaleResponsitory.findAll();
	}

	@Override
	public  List<ItemSale> findAllById(List<Integer> ids) {
		return (List<ItemSale>)itemSaleResponsitory.findAllById(ids);
	}

	@Override
	public long count() {
		return itemSaleResponsitory.count();
	}

	@Override
	public void deleteById(Integer id) {
		itemSaleResponsitory.deleteById(id);
	}

	@Override
	public void delete(ItemSale entity) {
		itemSaleResponsitory.delete(entity);
	}

	@Override
	public void deleteAll( List<ItemSale> entities) {
		itemSaleResponsitory.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		itemSaleResponsitory.deleteAll();
	}
	
		
}
