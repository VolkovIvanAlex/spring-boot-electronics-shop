package aim.traineeship.electronics.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aim.traineeship.electronics.shop.converter.impl.dto.AddressDTOConverter;
import aim.traineeship.electronics.shop.dao.AddressDAO;
import aim.traineeship.electronics.shop.dto.AddressDTO;
import aim.traineeship.electronics.shop.service.AddressService;


@Service
public class DefaultAddressService implements AddressService
{
	@Autowired
	private AddressDAO addressDAO;

	@Autowired
	private AddressDTOConverter addressDTOConverter;

	@Override
	public Integer addAddressAndReturnId(final AddressDTO addressDTO)
	{
		return addressDAO.saveAddress(addressDTOConverter.convert(addressDTO));
	}
}
