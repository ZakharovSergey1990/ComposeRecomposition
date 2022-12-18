
package com.example.composerecomposition.page.third_tip_page

import androidx.compose.material.Scaffold
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.anothermodule.Company
import com.example.composerecomposition.model.ComposeCompany
import com.example.composerecomposition.model.convertToComposeClass
import com.example.composerecomposition.ui_component.AppBar
import com.example.composerecomposition.ui_component.BasePage
import com.example.composerecomposition.ui_component.InfoDialog
import com.example.composerecomposition.constant.TipInfo
import kotlinx.coroutines.flow.map

@Composable
fun ThirdTipPage(vm: ThirdPageViewModel = hiltViewModel()) {
    InfoDialog(title = "Third tip information", info = TipInfo.FIRST_PAGE_INFO)
    Scaffold(topBar = {
        AppBar("Third Tip")
    }) {
        InfoDialog(title = "Third tip information" , info = TipInfo.THIRD_PAGE_INFO)
        BasePage(wrongTabContent = {
            ThirdTipWrongContent(vm)
        },
            wrightTabContent = {
                ThirdTipWrightContent(vm)
            }
        )
    }
}

@Composable
fun ThirdTipWrongContent(vm: ThirdPageViewModel) {
    val companies by vm.companies.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = vm::mixCompanies, modifier = Modifier.fillMaxWidth(0.9f)) {
            Text("mix companies")
        }
        companies.forEach { company ->
            key(company.id) { CompanyItem(company = company) }
        }
    }
}



@Composable
fun ThirdTipWrightContent(vm: ThirdPageViewModel) {
    val companies by vm.companies.map { list -> list.map { it.convertToComposeClass() } }.collectAsState(emptyList())
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = vm::mixCompanies , modifier = Modifier.fillMaxWidth(0.9f)) {
            Text("mix companies")
        }
        companies.forEach { company ->
            key(company.id) {
                ComposeCompanyItem(company = company)
            }
        }
    }
}


@Composable
fun CompanyItem(company: Company) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(text = company.name)
        Text(text = company.id.toString())
    }
    Divider(modifier = Modifier.padding(16.dp))
}

@Composable
fun ComposeCompanyItem(company: ComposeCompany) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(0.9f)
    ) {
        Text(text = company.name)
        Text(text = company.id.toString())
    }
    Divider(modifier = Modifier.padding(16.dp))
}