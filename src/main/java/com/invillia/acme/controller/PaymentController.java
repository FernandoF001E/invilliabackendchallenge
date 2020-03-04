package com.invillia.acme.controller;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.invillia.acme.entity.Payment;
import com.invillia.acme.helpers.JsonReturn;
import com.invillia.acme.repository.PaymentRepository;

@RestController
public class PaymentController {
	@Autowired
	private PaymentRepository _paymentRepository;

	@RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
	public JsonReturn<Payment> GetById(@PathVariable(value = "id") long id) {
		JsonReturn<Payment> result = new JsonReturn<Payment>();
		try {
			Optional<Payment> payment = _paymentRepository.findById(id);
			if (payment.isPresent()) {
				result.SetSuccess(payment.get());
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new Payment(id));
		}
		return result;
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public JsonReturn<Payment> Post(@Valid @RequestBody Payment payment) {
		JsonReturn<Payment> result = new JsonReturn<Payment>();
		try {
			result.SetSuccess(_paymentRepository.save(payment));
		} catch (Exception ex) {
			result.SetException(ex, null);
		}
		return result;
	}

	@RequestMapping(value = "/payment/{id}", method = RequestMethod.PUT)
	public JsonReturn<Payment> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Payment newPayment) {
		JsonReturn<Payment> result = new JsonReturn<Payment>();
		try {
			Optional<Payment> oldPayment = _paymentRepository.findById(id);
			if (oldPayment.isPresent()) {
				Payment payment = oldPayment.get();
				payment.setCredicardnumber(newPayment.getCredicardnumber());
				payment.setPaymentdate(newPayment.getPaymentdate());
				payment.setStatus(newPayment.getStatus());
				result.SetSuccess(_paymentRepository.save(payment));
			} else {
				result.SetNotFound(null);
			}
		} catch (Exception ex) {
			result.SetException(ex);
			result.SetException(ex, new Payment(id));
		}
		return result;
	}
}
