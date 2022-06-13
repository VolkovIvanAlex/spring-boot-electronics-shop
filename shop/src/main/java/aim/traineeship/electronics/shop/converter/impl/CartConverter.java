package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.entities.Cart;


@Component
public class CartConverter implements Converter<Cart , CartDTO>
{
	@Autowired
	private CustomerConverter customerConverter;

	@Override
	public CartDTO convert(final Cart cart)
	{
		final CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getId());
		cartDTO.setCode(cart.getCode());
		cartDTO.setPlacedDate(cart.getPlacedDate());
		cartDTO.setTotalPrice(cart.getTotalPrice());
		cartDTO.setCustomerDTO(customerConverter.convert(cart.getCustomer()));
		return cartDTO;
	}
}
