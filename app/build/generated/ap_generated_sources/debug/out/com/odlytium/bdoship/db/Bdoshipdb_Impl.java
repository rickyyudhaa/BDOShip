package com.odlytium.bdoship.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.odlytium.bdoship.dao.MatsDao;
import com.odlytium.bdoship.dao.MatsDao_Impl;
import com.odlytium.bdoship.dao.OwnedprogressDao;
import com.odlytium.bdoship.dao.OwnedprogressDao_Impl;
import com.odlytium.bdoship.dao.ProgressDao;
import com.odlytium.bdoship.dao.ProgressDao_Impl;
import com.odlytium.bdoship.dao.ShipDao;
import com.odlytium.bdoship.dao.ShipDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class Bdoshipdb_Impl extends Bdoshipdb {
  private volatile ShipDao _shipDao;

  private volatile ProgressDao _progressDao;

  private volatile MatsDao _matsDao;

  private volatile OwnedprogressDao _ownedprogressDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ship_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT, `material` TEXT, `icon` INTEGER NOT NULL, `inventory` INTEGER NOT NULL, `cabins` INTEGER NOT NULL, `cannonballs` INTEGER NOT NULL, `cannons` INTEGER NOT NULL, `lt` INTEGER NOT NULL, `speed` INTEGER NOT NULL, `turn` INTEGER NOT NULL, `accel` INTEGER NOT NULL, `brake` INTEGER NOT NULL, `reload` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `progressentity_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_material` INTEGER NOT NULL, `haveMaterial` INTEGER NOT NULL, `reqMaterial` INTEGER NOT NULL, `id_ship` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `material_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `image` INTEGER NOT NULL, `price` INTEGER NOT NULL, `qtyperday` INTEGER NOT NULL, `barter` INTEGER NOT NULL, `daily` INTEGER NOT NULL, `coin` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ownedprogress_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id_ship` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"33fe016b00e9c47fc3cace6de3178489\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ship_table`");
        _db.execSQL("DROP TABLE IF EXISTS `progressentity_table`");
        _db.execSQL("DROP TABLE IF EXISTS `material_table`");
        _db.execSQL("DROP TABLE IF EXISTS `ownedprogress_table`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsShipTable = new HashMap<String, TableInfo.Column>(14);
        _columnsShipTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsShipTable.put("type", new TableInfo.Column("type", "TEXT", false, 0));
        _columnsShipTable.put("material", new TableInfo.Column("material", "TEXT", false, 0));
        _columnsShipTable.put("icon", new TableInfo.Column("icon", "INTEGER", true, 0));
        _columnsShipTable.put("inventory", new TableInfo.Column("inventory", "INTEGER", true, 0));
        _columnsShipTable.put("cabins", new TableInfo.Column("cabins", "INTEGER", true, 0));
        _columnsShipTable.put("cannonballs", new TableInfo.Column("cannonballs", "INTEGER", true, 0));
        _columnsShipTable.put("cannons", new TableInfo.Column("cannons", "INTEGER", true, 0));
        _columnsShipTable.put("lt", new TableInfo.Column("lt", "INTEGER", true, 0));
        _columnsShipTable.put("speed", new TableInfo.Column("speed", "INTEGER", true, 0));
        _columnsShipTable.put("turn", new TableInfo.Column("turn", "INTEGER", true, 0));
        _columnsShipTable.put("accel", new TableInfo.Column("accel", "INTEGER", true, 0));
        _columnsShipTable.put("brake", new TableInfo.Column("brake", "INTEGER", true, 0));
        _columnsShipTable.put("reload", new TableInfo.Column("reload", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysShipTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesShipTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoShipTable = new TableInfo("ship_table", _columnsShipTable, _foreignKeysShipTable, _indicesShipTable);
        final TableInfo _existingShipTable = TableInfo.read(_db, "ship_table");
        if (! _infoShipTable.equals(_existingShipTable)) {
          throw new IllegalStateException("Migration didn't properly handle ship_table(com.odlytium.bdoship.entity.Ship).\n"
                  + " Expected:\n" + _infoShipTable + "\n"
                  + " Found:\n" + _existingShipTable);
        }
        final HashMap<String, TableInfo.Column> _columnsProgressentityTable = new HashMap<String, TableInfo.Column>(5);
        _columnsProgressentityTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsProgressentityTable.put("id_material", new TableInfo.Column("id_material", "INTEGER", true, 0));
        _columnsProgressentityTable.put("haveMaterial", new TableInfo.Column("haveMaterial", "INTEGER", true, 0));
        _columnsProgressentityTable.put("reqMaterial", new TableInfo.Column("reqMaterial", "INTEGER", true, 0));
        _columnsProgressentityTable.put("id_ship", new TableInfo.Column("id_ship", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProgressentityTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProgressentityTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProgressentityTable = new TableInfo("progressentity_table", _columnsProgressentityTable, _foreignKeysProgressentityTable, _indicesProgressentityTable);
        final TableInfo _existingProgressentityTable = TableInfo.read(_db, "progressentity_table");
        if (! _infoProgressentityTable.equals(_existingProgressentityTable)) {
          throw new IllegalStateException("Migration didn't properly handle progressentity_table(com.odlytium.bdoship.entity.ProgressEntity).\n"
                  + " Expected:\n" + _infoProgressentityTable + "\n"
                  + " Found:\n" + _existingProgressentityTable);
        }
        final HashMap<String, TableInfo.Column> _columnsMaterialTable = new HashMap<String, TableInfo.Column>(8);
        _columnsMaterialTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsMaterialTable.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsMaterialTable.put("image", new TableInfo.Column("image", "INTEGER", true, 0));
        _columnsMaterialTable.put("price", new TableInfo.Column("price", "INTEGER", true, 0));
        _columnsMaterialTable.put("qtyperday", new TableInfo.Column("qtyperday", "INTEGER", true, 0));
        _columnsMaterialTable.put("barter", new TableInfo.Column("barter", "INTEGER", true, 0));
        _columnsMaterialTable.put("daily", new TableInfo.Column("daily", "INTEGER", true, 0));
        _columnsMaterialTable.put("coin", new TableInfo.Column("coin", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMaterialTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMaterialTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMaterialTable = new TableInfo("material_table", _columnsMaterialTable, _foreignKeysMaterialTable, _indicesMaterialTable);
        final TableInfo _existingMaterialTable = TableInfo.read(_db, "material_table");
        if (! _infoMaterialTable.equals(_existingMaterialTable)) {
          throw new IllegalStateException("Migration didn't properly handle material_table(com.odlytium.bdoship.entity.Material).\n"
                  + " Expected:\n" + _infoMaterialTable + "\n"
                  + " Found:\n" + _existingMaterialTable);
        }
        final HashMap<String, TableInfo.Column> _columnsOwnedprogressTable = new HashMap<String, TableInfo.Column>(2);
        _columnsOwnedprogressTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsOwnedprogressTable.put("id_ship", new TableInfo.Column("id_ship", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOwnedprogressTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOwnedprogressTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOwnedprogressTable = new TableInfo("ownedprogress_table", _columnsOwnedprogressTable, _foreignKeysOwnedprogressTable, _indicesOwnedprogressTable);
        final TableInfo _existingOwnedprogressTable = TableInfo.read(_db, "ownedprogress_table");
        if (! _infoOwnedprogressTable.equals(_existingOwnedprogressTable)) {
          throw new IllegalStateException("Migration didn't properly handle ownedprogress_table(com.odlytium.bdoship.entity.Ownedprogress).\n"
                  + " Expected:\n" + _infoOwnedprogressTable + "\n"
                  + " Found:\n" + _existingOwnedprogressTable);
        }
      }
    }, "33fe016b00e9c47fc3cace6de3178489", "d70a7217fd5fc9bf97d2332782886d45");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "ship_table","progressentity_table","material_table","ownedprogress_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ship_table`");
      _db.execSQL("DELETE FROM `progressentity_table`");
      _db.execSQL("DELETE FROM `material_table`");
      _db.execSQL("DELETE FROM `ownedprogress_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ShipDao shipDao() {
    if (_shipDao != null) {
      return _shipDao;
    } else {
      synchronized(this) {
        if(_shipDao == null) {
          _shipDao = new ShipDao_Impl(this);
        }
        return _shipDao;
      }
    }
  }

  @Override
  public ProgressDao progressDao() {
    if (_progressDao != null) {
      return _progressDao;
    } else {
      synchronized(this) {
        if(_progressDao == null) {
          _progressDao = new ProgressDao_Impl(this);
        }
        return _progressDao;
      }
    }
  }

  @Override
  public MatsDao matsDao() {
    if (_matsDao != null) {
      return _matsDao;
    } else {
      synchronized(this) {
        if(_matsDao == null) {
          _matsDao = new MatsDao_Impl(this);
        }
        return _matsDao;
      }
    }
  }

  @Override
  public OwnedprogressDao ownedprogressDao() {
    if (_ownedprogressDao != null) {
      return _ownedprogressDao;
    } else {
      synchronized(this) {
        if(_ownedprogressDao == null) {
          _ownedprogressDao = new OwnedprogressDao_Impl(this);
        }
        return _ownedprogressDao;
      }
    }
  }
}
