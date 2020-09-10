#!/usr/bin/env groovy

def call(String commands) {
  if(env.BRANCH_NAME == /PR-.*/) {
    ruby_string = "${env.RUBY_VERSION}@pr-${env.RUBY_GEMSET}"
  }
  else {
    ruby_string = "${env.RUBY_VERSION}@${env.RUBY_GEMSET}"
  }
  if (env.DEBUG == 'true') {
    echo "*************************"
    echo "RVM Commands: ${commands}"
    echo "*************************"
  }
  sh "bash -c \"source /usr/local/rvm/scripts/rvm && rvm use --install --create ${ruby_string} && ${commands}\""
  echo "DEBUG is ${DEBUG} RUBY_STRING is ${env.RUBY_VERSION}@${env.RUBY_GEMSET}"
}
