package com.backend.Restro.services;

import com.backend.Restro.repository.TablesRepository;
import org.springframework.stereotype.Service;

@Service
public class TablesService {
    private TablesRepository  tablesRepository;
    TablesService(TablesRepository tablesRepository)
    {
        this.tablesRepository = tablesRepository;
    }


}
