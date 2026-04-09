package app.meetlog.mobile.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.meetlog.mobile.R

@Composable
fun HomeScreen(
    onOpenSettings: () -> Unit,
    onOpenBilling: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.home_title),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = stringResource(R.string.home_subtitle),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = stringResource(R.string.home_backup_note),
            style = MaterialTheme.typography.bodyMedium
        )
        Button(onClick = onOpenSettings) {
            Text(text = stringResource(R.string.action_open_settings))
        }
        Button(onClick = onOpenBilling) {
            Text(text = stringResource(R.string.action_open_billing))
        }
    }
}
