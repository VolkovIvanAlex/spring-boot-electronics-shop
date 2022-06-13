package aim.traineeship.electronics.shop.converter.impl.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.entities.Cart;

@Component
public class CartDTOConverter implements Converter<CartDTO , Cart>
{
	@Autowired
	private CustomerDTOConverter customerDTOConverter;

	@Override
	public Cart convert(final CartDTO cartDTO)
	{
		final Cart cart = new Cart();
		cart.setId(cartDTO.getId());
		cart.setCode(cartDTO.getCode());
		if (cartDTO.getPlacedDate() != null){
			cart.setPlacedDate(cartDTO.getPlacedDate());
		}
		cart.setTotalPrice(cartDTO.getTotalPrice());
		cart.setCustomer(customerDTOConverter.convert(cartDTO.getCustomerDTO()));

		return cart;
	}
}
