package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.AddressDTO;
import aim.traineeship.electronics.shop.dto.CartDTO;
import aim.traineeship.electronics.shop.dto.CustomerDTO;
import aim.traineeship.electronics.shop.entities.Address;
import aim.traineeship.electronics.shop.entities.Cart;
import aim.traineeship.electronics.shop.entities.Customer;


@Component
public class CartConverter implements Converter<Cart, CartDTO>
{
	@Override
	public CartDTO convert(final Cart cart)
	{
		final CartDTO cartDTO = new CartDTO();
		cartDTO.setCode(cart.getCode());
		cartDTO.setPlacedDate(cart.getPlacedDate());
		cartDTO.setTotalPrice(cart.getTotalPrice());

		final CustomerDTO customerDTO = new CustomerDTO();
		final Customer customer = cart.getCustomer();
		customerDTO.setLogin(customer.getLogin());
		customerDTO.setPassword(customer.getPassword());
		customerDTO.setFirstName(customer.getFirstName());
		customerDTO.setLastName(customer.getLastName());
		customerDTO.setGender(customer.getGender().name());
		customerDTO.setBirthDay(customer.getBirthDay().toString());
		customerDTO.setPhone(customer.getPhone());

		cartDTO.setCustomerDTO(customerDTO);

		final Address address = cart.getAddress();
		if (address != null)
		{
			final AddressDTO addressDTO = new AddressDTO();
			addressDTO.setStreet(address.getStreet());
			addressDTO.setRegion(address.getRegion());
			addressDTO.setTown(address.getTown());
			addressDTO.setCountry(address.getCountry());
			addressDTO.setZipCode(address.getZipCode());

			cartDTO.setAddressDTO(addressDTO);
		}

		return cartDTO;
	}
}
