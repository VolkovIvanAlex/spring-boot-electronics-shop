package aim.traineeship.electronics.shop.service;

import aim.traineeship.electronics.shop.dto.AddressDTO;


public interface AddressService
{
	Integer addAddressAndReturnId(final AddressDTO addressDTO);
}
