#
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
#
class hdp-oozie::oozie::service_check()
{
  include hdp-oozie::params

  $smoke_shell_files = ['oozieSmoke.sh']

  if (hdp_get_major_stack_version($stack_version) >= 2) {
    $smoke_test_file_name = 'oozieSmoke2.sh'
  } else {
    $smoke_test_file_name = 'oozieSmoke.sh'
  }

  anchor { 'hdp-oozie::oozie::service_check::begin':}

  hdp-oozie::smoke_shell_file { $smoke_shell_files:
    smoke_shell_file_name => $smoke_test_file_name
  }

  anchor{ 'hdp-oozie::oozie::service_check::end':}
}

define hdp-oozie::smoke_shell_file(
  $smoke_shell_file_name
)
{
  $smoke_test_user = $hdp::params::smokeuser
  $conf_dir = $hdp::params::oozie_conf_dir
  $hadoopconf_dir = $hdp::params::hadoop_conf_dir 
  $security_enabled=$hdp::params::security_enabled
  if ($security_enabled == true) {
    $security = "true"
  } else {
    $security = "false"
  }
  $smoke_user_keytab = $hdp::params::smokeuser_keytab
  $realm=$hdp::params::kerberos_domain
  $kinit_path = $hdp::params::kinit_path_local
  $nn_principal = $hdp::params::nn_principal
  $jt_principal = $hdp::params::jt_principal

  file { "/tmp/${smoke_shell_file_name}":
    ensure => present,
    source => "puppet:///modules/hdp-oozie/${smoke_shell_file_name}",
    mode => '0755'
  }

  exec { "/tmp/${smoke_shell_file_name}":
    command   => "sh /tmp/${smoke_shell_file_name} ${conf_dir} ${hadoopconf_dir} ${smoke_test_user} ${security} ${smoke_user_keytab} ${realm} $jt_host $nn_host",
    tries     => 3,
    try_sleep => 5,
    require   => File["/tmp/${smoke_shell_file_name}"],
    path      => '/usr/sbin:/sbin:/usr/local/bin:/bin:/usr/bin',
    logoutput => "true"
  }
}
