package aim.traineeship.electronics.shop.converter.impl;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.AddressDTO;
import aim.traineeship.electronics.shop.entities.Address;


@Component
public class AddressConverter implements Converter<Address, AddressDTO>
{
	@Override
	public AddressDTO convert(final Address address)
	{
		final AddressDTO addressDTO = new AddressDTO();
		addressDTO.setStreet(address.getStreet());
		addressDTO.setRegion(address.getRegion());
		addressDTO.setTown(address.getTown());
		addressDTO.setCountry(address.getCountry());
		addressDTO.setZipCode(address.getZipCode());

		return addressDTO;
	}
}
