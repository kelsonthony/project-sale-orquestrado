package com.kelsonthony.sale.adapters.in.controller.mapper;

import com.kelsonthony.sale.adapters.in.controller.request.SaleRequest;
import com.kelsonthony.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {

    Sale toSale(SaleRequest saleRequest);
}
