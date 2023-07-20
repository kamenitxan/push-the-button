package cz.kamenitxan.templateapp

import cz.kamenitxan.jakon.JakonInit
import cz.kamenitxan.jakon.core.Director
import cz.kamenitxan.jakon.core.database.DBHelper
import cz.kamenitxan.templateapp.controler.{IndexControler, ButtonsController}
import cz.kamenitxan.templateapp.entity.Button

/**
  * Created by TPa on 2019-08-24.
  */
class AppInit extends JakonInit {
	override def daoSetup(): Unit = {
		DBHelper.addDao(classOf[Button])

		Director.registerController(new IndexControler)
		Director.registerController(new ButtonsController)
	}


}