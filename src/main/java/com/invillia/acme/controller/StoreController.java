package com.invillia.acme.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.invillia.acme.entity.Store;
import com.invillia.acme.helpers.JsonReturn;
import com.invillia.acme.repository.StoreRepository;

@RestController
public class StoreController {
	@Autowired
	private StoreRepository _storeRepository;

	@RequestMapping(value = "/store/{id}", method = RequestMethod.GET)
	public JsonReturn<Store> GetById(@PathVariable(value = "id") long id) {
		JsonReturn<Store> result = new JsonReturn<Store>();
		try {
			Optional<Store> store = _storeRepository.findById(id);
			if (store.isPresent()) {
				result.SetSuccess(store.get());
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new Store(id));
		}
		return result;
	}

	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public JsonReturn<Store> Post(@Valid @RequestBody Store store) {
		JsonReturn<Store> result = new JsonReturn<Store>();
		try {
			result.SetSuccess(_storeRepository.save(store));
		} catch (Exception ex) {
			result.SetException(ex, null);
		}
		return result;
	}

	@RequestMapping(value = "/store/{id}", method = RequestMethod.PUT)
	public JsonReturn<Store> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Store newStore) {
		JsonReturn<Store> result = new JsonReturn<Store>();
		try {
			Optional<Store> oldStore = _storeRepository.findById(id);
			if (oldStore.isPresent()) {
				Store store = oldStore.get();
				store.setName(newStore.getName());
				store.setAddress(newStore.getAddress());
				result.SetSuccess(_storeRepository.save(store));
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new Store(id));
		}
		return result;
	}
}
