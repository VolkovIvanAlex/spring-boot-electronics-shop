package aim.traineeship.electronics.shop.converter.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.entities.Address;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.CartEntry;


@Component
public class CartConverter implements Converter<Cart, CartDTO>
{
	@Autowired
	private CartEntryConverter cartEntryConverter;

	@Autowired
	private CustomerConverter customerConverter;

	@Autowired
	private AddressConverter addressConverter;

	@Override
	public CartDTO convert(final Cart cart)
	{
		final CartDTO cartDTO = new CartDTO();
		cartDTO.setCode(cart.getCode());

		if (cart.getPlacedDate() != null)
		{
			cartDTO.setPlacedDate(cart.getPlacedDate());
		}

		cartDTO.setTotalPrice(cart.getTotalPrice());

		cartDTO.setCustomerDTO(customerConverter.convert(cart.getCustomer()));

		final Address address = cart.getAddress();
		if (address != null)
		{
			cartDTO.setAddressDTO(addressConverter.convert(address));
		}

		final List<CartEntry> cartEntries = cart.getCartEntries();
		if (cartEntries != null)
		{
			cartDTO.setCartEntries(cartEntryConverter.convertList(cartEntries));
		}

		return cartDTO;
	}
}
