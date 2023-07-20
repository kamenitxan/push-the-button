package cz.kamenitxan.templateapp.entity

import cz.kamenitxan.jakon.core.database.JakonField

import java.sql.{Connection, Statement}
import cz.kamenitxan.jakon.core.model.JakonObject
import cz.kamenitxan.jakon.webui.ObjectSettings

/**
  * Created by TPa on 2019-08-24.
  */
class Button extends JakonObject {

	@JakonField(searched = true)
	var identification: String = _
	@JakonField(searched = true)
	var name: String = _


	override val objectSettings: ObjectSettings = null
}
