package org.researchstack.sampleapp;

import android.content.Context;

import org.researchstack.backbone.storage.database.AppDatabase;
import org.researchstack.backbone.storage.database.sqlite.SqlCipherDatabaseHelper;
import org.researchstack.backbone.storage.file.EncryptionProvider;
import org.researchstack.backbone.storage.file.FileAccess;
import org.researchstack.backbone.storage.file.SimpleFileAccess;
import org.researchstack.backbone.storage.file.aes.AesProvider;
import org.researchstack.backbone.storage.file.auth.PinCodeConfig;
import org.researchstack.skin.AppPrefs;
import org.researchstack.skin.DataProvider;
import org.researchstack.skin.ResearchStack;
import org.researchstack.skin.ResourceManager;
import org.researchstack.skin.TaskProvider;
import org.researchstack.skin.UiManager;
import org.researchstack.skin.notification.NotificationConfig;
import org.researchstack.skin.notification.SimpleNotificationConfig;

public class SampleResearchStack extends ResearchStack
{

    @Override
    protected AppDatabase createAppDatabaseImplementation(Context context)
    {
        return SqlCipherDatabaseHelper.getInstance(context);
    }

    @Override
    protected FileAccess createFileAccessImplementation(Context context)
    {
        return new SimpleFileAccess();
    }

    @Override
    protected PinCodeConfig getPinCodeConfig(Context context)
    {
        long autoLockTime = AppPrefs.getInstance(context).getAutoLockTime();
        return new PinCodeConfig(autoLockTime);
    }

    @Override
    protected EncryptionProvider getEncryptionProvider(Context context)
    {
        return new AesProvider();
    }

    @Override
    protected ResourceManager createResourceManagerImplementation(Context context)
    {
        return new SampleResourceManager();
    }

    @Override
    protected UiManager createUiManagerImplementation(Context context)
    {
        return new SampleUiManager();
    }

    @Override
    protected DataProvider createDataProviderImplementation(Context context)
    {
        return new SampleDataProvider();
    }

    @Override
    protected TaskProvider createTaskProviderImplementation(Context context)
    {
        return new SampleTaskProvider(context);
    }

    @Override
    protected NotificationConfig createNotificationConfigImplementation(Context context)
    {
        return new SimpleNotificationConfig();
    }

}