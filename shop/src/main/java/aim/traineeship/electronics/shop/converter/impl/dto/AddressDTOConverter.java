package aim.traineeship.electronics.shop.converter.impl.dto;

import org.springframework.stereotype.Component;

import aim.traineeship.electronics.shop.converter.Converter;
import aim.traineeship.electronics.shop.dto.AddressDTO;
import aim.traineeship.electronics.shop.entities.Address;

@Component
public class AddressDTOConverter implements Converter<AddressDTO, Address>
{
	@Override
	public Address convert(final AddressDTO addressDTO)
	{
		final Address address = new Address();
		address.setId(addressDTO.getId());
		address.setStreet(addressDTO.getStreet());
		address.setTown(addressDTO.getTown());
		address.setRegion(addressDTO.getRegion());
		address.setZipCode(addressDTO.getZipCode());
		address.setCountry(addressDTO.getCountry());

		return address;
	}
}
