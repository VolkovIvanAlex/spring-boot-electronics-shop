package aim.traineeship.electronics.shop.dto;

import javax.validation.Valid;


public class CheckoutDTO
{
	@Valid
	private AddressDTO addressDTO;
	@Valid
	private AnonymousDTO anonymousDTO;

	public AddressDTO getAddressDTO()
	{
		return addressDTO;
	}

	public void setAddressDTO(final AddressDTO addressDTO)
	{
		this.addressDTO = addressDTO;
	}

	public AnonymousDTO getAnonymousDTO()
	{
		return anonymousDTO;
	}

	public void setAnonymousDTO(final AnonymousDTO anonymousDTO)
	{
		this.anonymousDTO = anonymousDTO;
	}
}
